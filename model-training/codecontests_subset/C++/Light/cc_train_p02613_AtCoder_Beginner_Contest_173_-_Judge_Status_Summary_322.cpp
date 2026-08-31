#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,c0=0,c1=0,c2=0,c3=0;
  cin>>n;
  string s;
  while(n--)
  {
  cin>>s;
  if(s=="AC")
  c0++;
  else if(s=="WA")
  c1++;
  else if(s=="TLE")
  c2++;
  else
  c3++;
  }
  cout<<"AC x "<<c0<<"\nWA x "<<c1<<"\nTLE x "<<c2<<"\nRE x "<<c3<<"\n";

}