#include <bits/stdc++.h>
using namespace std;
int n;
string second[100005], temp;
int sz[15];
long long ten[25];
void concatanation(string p, string q) {
  int cnt = 0;
  while (p.size() || q.size()) {
    if (p.empty()) {
      temp += q.back();
      q.pop_back();
    } else if (q.empty()) {
      temp += p.back();
      p.pop_back();
    } else {
      if (cnt % 2 == 0) {
        temp += q.back();
        q.pop_back();
      } else {
        temp += p.back();
        p.pop_back();
      }
    }
    cnt++;
  }
}
long long age(int a, int b) {
  string p = second[a];
  string q;
  for (int i = 0; i < b; i++) q += '0';
  temp.clear();
  concatanation(p, q);
  long long ret = 0;
  for (int i = 0; i < temp.size(); i++) {
    long long mul = (((temp[i] - '0') * ten[i]) % 998244353) * sz[b];
    mul %= 998244353;
    ret = (ret + mul) % 998244353;
  }
  return ret;
}
long long pore(int a, int b) {
  string p = second[a];
  string q;
  for (int i = 0; i < b; i++) q += '0';
  temp.clear();
  concatanation(q, p);
  long long ret = 0;
  for (int i = 0; i < temp.size(); i++) {
    long long mul = (((temp[i] - '0') * ten[i]) % 998244353) * sz[b];
    mul %= 998244353;
    ret = (ret + mul) % 998244353;
  }
  return ret;
}
int main() {
  {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
  };
  ten[0] = 1;
  for (int i = 1; i <= 20; i++) ten[i] = (ten[i - 1] * 10) % 998244353;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> second[i];
  for (int i = 0; i < n; i++) sz[second[i].size()]++;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 10; j++) {
      ans = (ans + age(i, j)) % 998244353;
      ans = (ans + pore(i, j)) % 998244353;
    }
  }
  cout << ans << endl;
}
