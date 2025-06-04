# olx_scraper.py
import requests
from bs4 import BeautifulSoup
import csv

URL = "https://www.olx.in/items/q-car-cover"
headers = {
    "User-Agent": "Mozilla/5.0"
}

response = requests.get(URL, headers=headers)
soup = BeautifulSoup(response.text, 'html.parser')

results = []

# OLX dynamically loads content with JavaScript. This only gets static HTML.
# In real-world use, Selenium would be better.
for item in soup.find_all('li'):
    title = item.find('h6')
    price = item.find('span')
    if title and price:
        results.append({
            "title": title.text.strip(),
            "price": price.text.strip()
        })

# Write to file
with open('olx_car_cover_results.csv', 'w', newline='', encoding='utf-8') as f:
    writer = csv.DictWriter(f, fieldnames=["title", "price"])
    writer.writeheader()
    writer.writerows(results)

print("Scraping complete. Results saved to olx_car_cover_results.csv")
