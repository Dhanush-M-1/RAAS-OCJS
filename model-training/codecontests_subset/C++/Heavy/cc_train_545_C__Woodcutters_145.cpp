#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
template <typename T>
void showvector(vector<T> v) {
  for (T x : v) cout << x << " ";
  cout << "\n";
}
template <typename T>
void showvector1(vector<T> v) {
  long long int n = v.size();
  for (long long int i = 1; i <= n - 1; i++) cout << v[i] << "\n";
}
template <typename T>
void showset(set<T> s) {
  for (T x : s) cout << x << " ";
  cout << "\n";
}
template <class T>
void showvectorpair(vector<T> v) {
  for (auto it = v.begin(); it != v.end(); it++)
    cout << it->first << " " << it->second << "\n";
  cout << "\n";
}
template <typename T, typename P>
void showmap(map<T, P> m) {
  for (auto it = m.begin(); it != m.end(); it++)
    cout << it->first << " " << it->second << "\n";
  cout << "\n";
}
template <typename T>
bool comp(T a, T b) {
  return (a > b);
}
template <class T>
bool comppair(T a, T b) {
  if (a.first == b.first) return (a.second > b.second);
  return (a.first > b.first);
}
bool sameparity(long long int a, long long int b) { return (a % 2 == b % 2); }
bool difparity(long long int a, long long int b) { return !(a % 2 == b % 2); }
bool isprime(long long int x) {
  if (x <= 1) return false;
  for (long long int i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) return false;
  }
  return true;
}
bool iseven(long long int x) { return !(x % 2); }
bool isodd(long long int x) { return (x % 2); }
char add(char a, char b) {
  if (a == '1' && b == '1')
    return '2';
  else if (a == '1' || b == '1')
    return '1';
  else
    return '0';
}
map<long long int, long long int> m;
long long int n;
long long int fun(long long int xcord) {
  auto it = m.lower_bound(xcord);
  if (it == m.begin()) {
    if (it->first == xcord)
      return 1;
    else
      return 0;
  }
  if (it->first == xcord) {
    auto pt = it;
    advance(pt, -1);
    return max(1 + fun(it->first - it->second), fun(pt->first));
  } else {
    advance(it, -1);
    auto pt = it;
    advance(pt, -1);
    return max(1 + fun(it->first - it->second), fun(pt->first));
  }
}
vector<long long int> x(100005), h(100005), lt(100005), rt(100005),
    stay(100005);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int test = 1;
  while (test--) {
    long long int n;
    cin >> n;
    for (long long int i = 1; i <= n; i++) {
      cin >> x[i] >> h[i];
    }
    x[0] = LLONG_MIN;
    x[n + 1] = LLONG_MAX;
    stay[0] = lt[0] = rt[0] = 0;
    for (long long int i = 1; i <= n; i++) {
      stay[i] = max(stay[i - 1], lt[i - 1]);
      if (x[i - 1] + h[i - 1] < x[i]) {
        stay[i] = max(stay[i], rt[i - 1]);
      }
      if (x[i] - h[i] > x[i - 1]) {
        lt[i] = 1 + max(lt[i - 1], stay[i - 1]);
        if (x[i] - h[i] > x[i - 1] + h[i - 1]) {
          lt[i] = max(lt[i], rt[i - 1] + 1);
        }
      }
      if (x[i] + h[i] < x[i + 1]) {
        rt[i] = max({lt[i - 1], rt[i - 1], stay[i - 1]}) + 1;
      }
    }
    cout << max({lt[n], rt[n], stay[n]});
  }
}
