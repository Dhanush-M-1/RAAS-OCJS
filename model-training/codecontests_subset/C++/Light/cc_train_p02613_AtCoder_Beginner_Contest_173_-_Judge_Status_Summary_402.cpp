#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,i;
  cin>>n;
  map<string,int> a;
  for(i=0;i<n;i++)
  {
  	string s;
  	cin>>s;
  	a[s]++;
  }
  cout<<"AC x "<<a["AC"]<<endl;
  cout<<"WA x "<<a["WA"]<<endl;
 cout<<"TLE x "<<a["TLE"]<<endl;
 cout<<"RE x "<<a["RE"]<<endl;
}