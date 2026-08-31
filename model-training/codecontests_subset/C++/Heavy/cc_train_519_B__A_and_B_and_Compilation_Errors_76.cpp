#include <bits/stdc++.h>
using namespace std;
map<long long, long long> m;
map<long long, long long> m1;
vector<long long> v;
int main() {
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    m[x]++;
    m1[x]++;
  }
  for (long long i = 0; i < n - 1; i++) {
    long long y;
    cin >> y;
    m1[y]++;
    m1[y]--;
    m[y]--;
  }
  map<long long, long long>::iterator t = m.begin();
  long long sul;
  while (t != m.end()) {
    pair<long long, long long> p = (*t);
    while (m[p.first] > 0) {
      sul = p.first;
      m[p.first]--;
    }
    t++;
  }
  for (long long i = 0; i < n - 2; i++) {
    long long y;
    cin >> y;
    m1[y]--;
    if (m1[y] == 0) {
      m1.erase(y);
    }
  }
  map<long long, long long>::iterator tt = m1.begin();
  while (tt != m1.end()) {
    pair<long long, long long> p = (*tt);
    while (m1[p.first] > 0) {
      v.push_back(p.first);
      m1[p.first]--;
    }
    tt++;
  }
  if (v[0] == sul)
    cout << v[0] << endl << v[1] << endl;
  else if (v[1] == sul)
    cout << v[1] << endl << v[0] << endl;
  return 0;
}
