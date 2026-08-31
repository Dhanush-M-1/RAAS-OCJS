#include <bits/stdc++.h>
using namespace std;
template <class T1>
void debug(T1 e) {
  cout << e << endl;
}
template <class T1, class T2>
void debug(T1 e1, T2 e2) {
  cout << e1 << "\t" << e2 << endl;
}
template <class T1, class T2, class T3>
void debug(T1 e1, T2 e2, T3 e3) {
  cout << e1 << "\t" << e2 << "\t" << e3 << endl;
}
template <class T1, class T2, class T3, class T4>
void debug(T1 e1, T2 e2, T3 e3, T4 e4) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << endl;
}
template <class T1, class T2, class T3, class T4, class T5>
void debug(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << "\t" << e5 << endl;
}
template <class T1, class T2, class T3, class T4, class T5, class T6>
void debug(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5, T6 e6) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << "\t" << e5 << "\t"
       << e6 << endl;
}
template <class T>
void debug(vector<vector<T> > e, int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << " ";
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(vector<basic_string<T> > e, int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j];
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(T e[110][110], int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << " ";
    cout << endl;
  }
}
template <class T>
string toString(T n) {
  ostringstream oss;
  oss << n;
  oss.flush();
  return oss.str();
}
int toInt(string s) {
  int r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
bool isVowel(char ch) {
  ch = tolower(ch);
  if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
    return true;
  return false;
}
bool isUpper(char c) { return c >= 'A' && c <= 'Z'; }
bool isLower(char c) { return c >= 'a' && c <= 'z'; }
int dp[25][8];
bool col[25][8];
char str[25];
int now;
long long ans[10];
int dprec(int in, int carry) {
  if (in < 0) return (!carry);
  int &ret = dp[in][carry];
  if (col[in][carry] == now) return ret;
  col[in][carry] = now;
  int i, j;
  ret = 0;
  for (i = 0; i <= 6 && !ret; i++)
    for (j = 0; i + j <= 6 && !ret; j++) {
      int tot = i * 4 + j * 7 + carry;
      if ((tot % 10) != (str[in] - '0')) continue;
      tot /= 10;
      ret = dprec(in - 1, tot);
      if (!ret) continue;
      int k;
      for (k = 1; k <= i; k++) ans[k] = 10 * ans[k] + 4;
      for (; k <= i + j; k++) ans[k] = 10 * ans[k] + 7;
      for (; k <= 6; k++) ans[k] = 10 * ans[k];
    }
  return ret;
}
int main() {
  int t;
  cin >> t;
  now = 0;
  while (t--) {
    now++;
    int i;
    memset(ans, 0, sizeof(ans));
    scanf("%s", str);
    int n = strlen(str);
    if (!dprec(n - 1, 0))
      cout << "-1" << endl;
    else {
      cout << ans[1];
      for (i = 2; i <= 6; i++) cout << " " << ans[i];
      cout << endl;
    }
  }
  return 0;
}
