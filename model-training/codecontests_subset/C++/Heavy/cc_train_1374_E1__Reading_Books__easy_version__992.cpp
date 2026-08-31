#include <bits/stdc++.h>
using namespace std;
bool rev(long long x, long long y) { return x > y; }
void input_arr(long long a[], long long n) {
  for (long long i = 0; i < n; i += 1) cin >> a[i];
}
bool sortbysec(const pair<long long, long long> &a,
               const pair<long long, long long> &b) {
  return a.second < b.second;
}
bool sortinrev(const pair<long long, long long> &a,
               const pair<long long, long long> &b) {
  return (a.first > b.first);
}
void print_vec(vector<long long> &v) {
  for (auto i : v) cout << i << " ";
  cout << '\n';
}
bool sortinrevbysec(const pair<long long, long long> &a,
                    const pair<long long, long long> &b) {
  return (a.second > b.second);
}
void print_arr(long long a[], long long n) {
  for (long long i = 0; i < n; i += 1) cout << a[i] << " ";
  cout << '\n';
}
template <typename... T>
void input(T &...args) {
  ((cin >> args), ...);
}
template <typename... T>
void print(T &&...args) {
  ((cout << args << '\n'), ...);
}
template <typename... T>
void deb(T &&...args) {
  cout << "~~ ";
  ((cout << args << " "), ...);
  cout << '\n';
}
void stand8th() {
  long long n, k;
  input(n, k);
  long long t, a, b;
  vector<long long> al, bo, bt;
  long long no = 0;
  for (long long i = 0; i < n; i += 1) {
    input(t, a, b);
    if (a == 1 && b == 1) {
      bt.push_back(t);
    } else if (a == 1) {
      al.push_back(t);
    } else if (b == 1) {
      bo.push_back(t);
    } else {
      no++;
    }
  }
  if ((long long)(al.size()) + (long long)(bo.size()) +
          2 * (long long)(bt.size()) <
      2 * k) {
    print(-1);
    return;
  }
  sort((al).begin(), (al).end());
  sort((bo).begin(), (bo).end());
  sort((bt).begin(), (bt).end());
  for (long long i = 1; i < (long long)(al.size()); i += 1) al[i] += al[i - 1];
  for (long long i = 1; i < (long long)(bo.size()); i += 1) bo[i] += bo[i - 1];
  for (long long i = 1; i < (long long)(bt.size()); i += 1) bt[i] += bt[i - 1];
  long long ans = INT64_MAX;
  for (long long i = 0; i < min((long long)(bt.size()), k); i += 1) {
    long long x = k - i - 1;
    if (x != 0 && (long long)(al.size()) >= x && (long long)(bo.size()) >= x) {
      ans = min(ans, bt[i] + al[x - 1] + bo[x - 1]);
    } else {
      if (x == 0) {
        ans = min(ans, bt[i]);
      }
    }
  }
  if ((long long)(al.size()) >= k && (long long)(bo.size()) >= k) {
    ans = min(ans, al[k - 1] + bo[k - 1]);
  }
  if (ans == INT64_MAX) {
    ans = -1;
  }
  print(ans);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long tin = 1;
  while (tin--) {
    stand8th();
  }
  return 0;
}
