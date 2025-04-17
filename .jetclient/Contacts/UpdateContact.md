```toml
name = 'UpdateContact'
description = 'Update contact details'
method = 'PUT'
url = 'http://localhost:8050/contacts'
sortWeight = 4000000
id = 'b85ced62-f41e-41e0-91b5-ac759815dbdc'

[body]
type = 'JSON'
raw = '''
{
  "id": "fe3f2824-56f5-4fb0-b328-5c3052b2b65b",
  "name": "Tinashe Chitakunye",
  "address": "10 Langside Court, 33 Fife Avenue, Harare",
  "phone": "263775031338",
  "title": "Backend Developer",
  "email": "tinashe@theasbyte.site",
  "active": true
}'''
```
