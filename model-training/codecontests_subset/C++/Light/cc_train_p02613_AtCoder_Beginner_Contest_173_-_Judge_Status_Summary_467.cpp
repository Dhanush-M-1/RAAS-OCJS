#include <bits/stdc++.h>
using namespace std;

int main() {
  int N;
  cin >> N;
  string S;
  map<string, int> MA;
  while (cin >> S) MA[S]++;
  cout << "AC x " << MA["AC"] << "\n";
  cout << "WA x " << MA["WA"] << "\n";
  cout << "TLE x " << MA["TLE"] << "\n";
  cout << "RE x " << MA["RE"] << "\n";
}