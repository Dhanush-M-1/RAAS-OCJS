#include <bits/stdc++.h>
using namespace std;
int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int check(string s) {
  if (s[2] != '-' || s[5] != '-') return 0;
  for (int i = 0; i < 10; i++)
    if (i != 2 && i != 5)
      if (s[i] == '-') return 0;
  int mm = stoi(s.substr(3, 2));
  int dd = stoi(s.substr(0, 2));
  int yyyy = stoi(s.substr(6, 4));
  if (yyyy < 2013 || yyyy > 2015) return 0;
  if (mm == 0 || mm > 12) return 0;
  if (dd == 0 || dd > month[mm - 1]) return 0;
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string s;
  cin >> s;
  int n = s.size();
  map<string, int> mapper;
  string best;
  for (int i = 0; i + 9 < n; i++) {
    string curr = s.substr(i, 10);
    if (check(curr)) mapper[curr]++;
    if (mapper[curr] > mapper[best]) best = curr;
  }
  cout << best << '\n';
}
