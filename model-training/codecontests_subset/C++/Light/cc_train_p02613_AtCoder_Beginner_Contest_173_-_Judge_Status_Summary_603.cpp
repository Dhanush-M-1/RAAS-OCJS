#include<bits/stdc++.h>

using namespace std;

int main()
{
  int n;
  cin>>n;
  string a;
  map<string,int> hash;
  while(n--)
  {
    cin>>a;
    hash[a]++;
  }
  cout<<"AC x "<<hash["AC"]<<endl;
	cout<<"WA x "<<hash["WA"]<<endl;
	cout<<"TLE x "<<hash["TLE"]<<endl;
	cout<<"RE x "<<hash["RE"]<<endl;
  return 0;
}
  