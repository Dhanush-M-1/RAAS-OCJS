#include<bits/stdc++.h>
#define ll long long
#define mod 1000000007
using namespace std;
int main()
{
int n;
cin>>n;
string s;
map<string,int> mp;
while(n--)
{
cin>>s;
mp[s]++;
}
string k[4]={"AC","WA","TLE","RE"};
for(int i=0;i<4;i++)
{
cout<<k[i]<<" x "<<mp[k[i]]<<endl;
}
}