#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[8] = {1, -1, 0, 0, 1, -1, 1, -1};
template <typename T>
inline T BigMod(T A, T B) {
  T ret = 1;
  while (B) {
    if (B & 1) ret = (ret * A) % 1000000007;
    A = (A * A) % 1000000007;
    B = B >> 1;
  }
  return ret;
}
template <typename T>
inline T InvMod(T A, T M = 1000000007) {
  return BigMod(A, M - 2);
}
string tostring(long long int res) {
  string curstr = "";
  while (res != 0) {
    long long int temp = (res % 10);
    curstr += ((char)temp + '0');
    res /= 10;
  }
  reverse(curstr.begin(), curstr.end());
  return curstr;
}
long long int toint(string ss) {
  long long int inss = 0;
  for (int i = 0; i < ss.size(); i++) {
    inss = (inss * 10) + ((int)(ss[i] - '0'));
  }
  return inss;
}
vector<int> vv;
int convert(int num, int base) {
  vv.clear();
  while (num != 0) {
    vv.push_back(num % base);
    num /= base;
  }
  int res = 0;
  for (int i = vv.size() - 1; i >= 0; i--) res = (res * 10) + vv[i];
  return res;
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        int temp = i * j;
        if (temp < n) {
          if (j == 1)
            cout << temp;
          else
            cout << " " << temp;
        } else {
          temp = convert(temp, n);
          if (j == 1)
            cout << temp;
          else
            cout << " " << temp;
        }
      }
      printf("\n");
    }
  }
}
