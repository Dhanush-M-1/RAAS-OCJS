#include <bits/stdc++.h>
using namespace std;
vector<int> find_div(int n) {
  vector<int> out;
  for (long long x = 1; x * x <= n; ++x) {
    if (n % x) continue;
    out.push_back(x);
    if (n / x != x) out.push_back(n / x);
  }
  sort(out.begin(), out.end());
  return out;
}
int cnv_to10(char ch) {
  if (isdigit(ch)) return ch - '0';
  return 10 + ch - 'A';
}
int get_bit(int val, int i) { return (val >> i) & 1; }
void fill_next4(vector<int>& dst, int& pos, int val) {
  for (int i = 3; i >= 0; --i, ++pos) dst[pos] = get_bit(val, i);
}
vector<vector<int> > calc_p_sum(const vector<vector<int> >& d) {
  int n = d.size();
  vector<vector<int> > p(n, vector<int>(n));
  p[0][0] = d[0][0];
  for (int j = 1; j < n; ++j) p[0][j] += p[0][j - 1] + d[0][j];
  for (int i = 1; i < n; ++i) p[i][0] += p[i - 1][0] + d[i][0];
  for (int i = 1; i < n; ++i)
    for (int j = 1; j < n; ++j)
      p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + d[i][j];
  return p;
}
int calc_sum(const vector<vector<int> >& p, int x, int y, int m) {
  int A = 0;
  if (x - 1 >= 0 && y - 1 >= 0) A = p[x - 1][y - 1];
  int B = 0;
  if (x - 1 >= 0) B = p[x - 1][y + m];
  int C = 0;
  if (y - 1 >= 0) C = p[x + m][y - 1];
  int D = p[x + m][y + m];
  return D - B - C + A;
}
int main() {
  std::ios::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<int> divisors = find_div(n);
  reverse(divisors.begin(), divisors.end());
  vector<vector<int> > d(n, vector<int>(n));
  for (int i = 0; i < n; ++i) {
    int pos = 0;
    string s;
    cin >> s;
    for (char ch : s) fill_next4(d[i], pos, cnv_to10(ch));
  }
  auto p_sum = calc_p_sum(d);
  for (int m : divisors) {
    bool failed = false;
    for (int i = 0; i < n; i += m) {
      for (int j = 0; j < n; j += m) {
        int ss = calc_sum(p_sum, i, j, m - 1);
        if (ss == 0 || ss == m * m) continue;
        failed = true;
        break;
      }
      if (failed) break;
    }
    if (!failed) {
      cout << m << endl;
      break;
    }
  }
  return 0;
}
