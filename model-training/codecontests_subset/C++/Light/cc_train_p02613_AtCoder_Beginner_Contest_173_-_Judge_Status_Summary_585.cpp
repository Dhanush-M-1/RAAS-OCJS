#include<bits/stdc++.h>
using namespace std;
map<string,int>mp;
int main()
{
  int n;
  cin>>n;
  for(int i=0;i<n;i++)
  {
      string x;
      cin>>x;
    mp[x]++;
  }
  vector<string>vt{"AC","WA","TLE","RE"};
  for(auto it:vt)
  {
      cout<<it<<" x "<<mp[it]<<endl;
  }
}