#include <bits/stdc++.h>
using namespace std;
long long min(long long a, long long b, long long c) {
  return min(a, min(b, c));
}
template <class T>
const T& max(const T& a, const T& b, const T& c) {
  return max(a, max(b, c));
}
template <class T>
const T& min(const T& a, const T& b, const T& c) {
  return min(a, min(b, c));
}
struct sp {
  bool operator()(const pair<string, int>& a, const pair<string, int>& b) {
    if (a.second != b.second) {
      return (a.second > b.second);
    }
    return (a.first < b.first);
  }
};
long long stoi(string& str) {
  istringstream second(str);
  long long i;
  second >> i;
  return i;
}
string itos(long long i) {
  stringstream second;
  second << i;
  return second.str();
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
int a[100001];
vector<int> v;
void dfs(long long i) {
  if (i > pow(10, 9)) return;
  if (i > 0) v.push_back(i);
  dfs(i * 10 + 4);
  dfs(i * 10 + 7);
}
int main() {
  map<long long, long long> m1, m2, m3;
  long long x;
  long long n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    m1[x]++;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    m2[x]++;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    m3[x]++;
  }
  for (auto itr = m1.begin(); itr != m1.end(); ++itr)
    if (itr->second != m2[itr->first]) {
      cout << itr->first << endl;
      break;
    }
  for (auto itr = m2.begin(); itr != m2.end(); ++itr)
    if (itr->second != m3[itr->first]) {
      cout << itr->first << endl;
      break;
    }
  return 0;
}
