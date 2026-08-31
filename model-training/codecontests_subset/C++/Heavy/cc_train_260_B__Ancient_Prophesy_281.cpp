#include <bits/stdc++.h>
using namespace std;
map<string, int> sum;
string ans;
int maks = -1;
int pola[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char in[100008];
int len;
bool valid(int a, int b) {
  for (int i = a; i <= b; i++) {
    if (i == a + 2 || i == a + 5) {
      if (in[i] != '-') return 0;
    } else {
      if (in[i] == '-') return 0;
    }
  }
  int day = ((in[a] - '0') * 10) + (in[a + 1] - '0');
  int month = ((in[a + 3] - '0') * 10) + (in[a + 4] - '0');
  int year = ((in[a + 6] - '0') * 1000) + ((in[a + 7] - '0') * 100) +
             ((in[a + 8] - '0') * 10) + (in[a + 9] - '0');
  if (year < 2013 || year > 2015) return 0;
  if (month < 1 || month > 13 || day < 1) return 0;
  if (day > pola[month - 1]) return 0;
  return 1;
}
void process() {
  int a = 0, b = 9;
  while (b < len) {
    if (valid(a, b)) {
      string tmp = "";
      for (int i = a; i <= b; i++) {
        tmp += in[i];
      }
      sum[tmp]++;
      int n = sum[tmp];
      if (n > maks) {
        maks = n;
        ans = tmp;
      }
    }
    a++;
    b++;
  }
hell:
  cout << ans << endl;
}
int main() {
  scanf("%s", in);
  len = strlen(in);
  process();
}
