#include <bits/stdc++.h>
using namespace std;

int main()
{
  int t;
  cin >> t;
  string s;
  map<string, int> mp;
  while(t--)
  {
    cin >> s;
    mp[s]++;
  }
  cout << "AC x " << mp["AC"] << "\n";
  cout << "WA x " << mp["WA"] << "\n";
  cout << "TLE x " << mp["TLE"] << "\n";
  cout << "RE x " << mp["RE"] << "\n";
}