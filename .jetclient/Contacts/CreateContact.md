```toml
name = 'CreateContact'
description = 'Create a new contact'
method = 'POST'
url = 'http://localhost:8050/contacts'
sortWeight = 1000000
id = 'dad61430-c431-4d4d-96b3-7d9063cf23c8'

[body]
type = 'JSON'
raw = '''
{
  "name": "Anesu Chitakunye",
  "email": "anesu@theasbyte.site",
  "phone": "263717054649",
  "title": "Secretary",
  "address": "6710 Zimre Park, Ruwa",
}'''
```
