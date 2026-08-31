#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > xy;
vector<pair<long long, long long> > ab;
vector<long long> x;
vector<long long> y;
string str, str1, str2, star[200000], str3;
long long ara[1000005], ara2[1000005];
bool flagar[200005], flagar2[200005];
bool compare(pair<long long, long long> i, pair<long long, long long> j) {
  return (i.first < j.first);
}
bool compare2(pair<long long, long long> i, pair<long long, long long> j) {
  return (i.first > j.first);
}
long long gcd(long long a, long long b) {
  if (a % b == 0) return b;
  return gcd(b, a % b);
}
map<long long, long long> dat;
map<long long, long long> dat2;
map<long long, long long> dat3;
int main() {
  double n, ans, temp, t, j, i, m, h, h2, m2, c, a, b, mx, d, k, s;
  cin >> n >> a >> b;
  temp = (b * n) / 100 - a;
  if (temp < 0) temp = 0;
  temp = ceil(temp);
  cout << temp;
  return 0;
}
