#include <bits/stdc++.h>
using namespace std;
string ntos(long long int n) {
  ostringstream str1;
  str1 << n;
  return str1.str();
}
long long int ston(string s) {
  long long int x;
  stringstream str1(s);
  str1 >> x;
  return x;
}
char a1[3] = {'R', 'G', 'B'};
char b1[3] = {'G', 'B', 'R'};
char c1[3] = {'B', 'R', 'G'};
bool bal(pair<long long int, long long int> a,
         pair<long long int, long long int> b) {
  return b.second > a.second;
}
int main() {
  int n;
  string s;
  cin >> n >> s;
  int e = 0;
  int h = (s.size()) / 11;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') e++;
  }
  cout << min(e, h);
}
