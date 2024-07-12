#!/usr/bin/env python
# coding: utf-8

# # Validate the data frame 

# In[33]:


import pandas as pd


# In[34]:


def read_file():
    df = pd.read_csv(filename)
    if(df.empty):
        print ('CSV file is empty')
    else:
        print ('CSV file is not empty')
        return df


# In[35]:


filename ='C:\\Users\\nfinity\\Downloads\\Data sets\\supermarket_sales.csv'


# In[36]:


df = read_file()


# In[9]:


df.head()


# # determine the csv data datatype by iterating the rows

# In[10]:


import pandas as pd
df = pd.read_csv('C:\\Users\\nfinity\\Downloads\\Data sets\\supermarket_sales.csv', nrows=2)
for dtype in df.dtypes.iteritems():
    print(dtype)


# In[16]:


df.head()


# # Processing the matched columns

# In[38]:


import pandas as pd
data = pd.read_csv('C:\\Users\\nfinity\\Downloads\\Data sets\\supermarket_sales.csv')


# In[30]:


df = df[sorted(data)]
validation = df
validation['chk'] = validation['Invoice ID'].apply(lambda x: True if x in df else False)
validation = validation[validation['chk'] == True].reset_index()
validation


# # Check Data Type convert as Date column

# In[39]:


for col in df.columns:
    if df[col].dtype == 'object':
        try:
            df[col] = pd.to_datetime(df[col])
        except ValueError:
            pass
print(df.dtypes)


# # validate data to check missing values 

# In[32]:


for col in df.columns:
    miss = df[col].isnull().sum()
    if miss>0:
        print("{} has {} missing value(s)".format(col,miss))
    else:
        print("{} has NO missing value!".format(col))


# In[29]:


df.dtypes


# In[ ]:




