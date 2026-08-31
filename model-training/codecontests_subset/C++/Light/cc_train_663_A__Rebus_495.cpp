#include <bits/stdc++.h>
using namespace std;
vector<long long> v;
int main() {
  char s;
  long long n, p = 1;
  v.push_back(1);
  while (true) {
    cin >> s;
    if (s == '+')
      p++, v.push_back(1);
    else if (s == '-')
      p--, v.push_back(-1);
    else if (s == '=')
      break;
  }
  cin >> n;
  for (int i = 0; i < v.size(); i++) {
    while (p < n && v[i] > 0 && v[i] < n) v[i]++, p++;
    while (p > n && v[i] < 0 && v[i] > -n) v[i]--, p--;
  }
  if (p != n) return cout << "Impossible", 0;
  cout << "Possible" << endl;
  cout << v[0] << " ";
  for (int i = 1; i < v.size(); i++) {
    if (v[i] > 0)
      cout << '+' << " ";
    else
      cout << '-' << " ";
    cout << ((v[i] < 0) ? (v[i] * -1) : (v[i])) << " ";
  }
  cout << '=' << " " << n;
  return 0;
}
