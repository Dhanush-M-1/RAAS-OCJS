#include <bits/stdc++.h>
using namespace std;
const int N = (5200 + 1);
int n, arr[N][N];
int conv[4];
string s;
void con(char ch) {
  conv[0] = 0;
  conv[1] = 0;
  conv[2] = 0;
  conv[3] = 0;
  if (ch == '1') {
    conv[3] = 1;
  } else if (ch == '2') {
    conv[0] = 0;
    conv[1] = 0;
    conv[2] = 1;
    conv[3] = 0;
  } else if (ch == '3') {
    conv[0] = 0;
    conv[1] = 0;
    conv[2] = 1;
    conv[3] = 1;
  } else if (ch == '4') {
    conv[0] = 0;
    conv[1] = 1;
    conv[2] = 0;
    conv[3] = 0;
  } else if (ch == '5') {
    conv[0] = 0;
    conv[1] = 1;
    conv[2] = 0;
    conv[3] = 1;
  } else if (ch == '6') {
    conv[0] = 0;
    conv[1] = 1;
    conv[2] = 1;
    conv[3] = 0;
  } else if (ch == '7') {
    conv[0] = 0;
    conv[1] = 1;
    conv[2] = 1;
    conv[3] = 1;
  } else if (ch == '8') {
    conv[0] = 1;
    conv[1] = 0;
    conv[2] = 0;
    conv[3] = 0;
  } else if (ch == '9') {
    conv[0] = 1;
    conv[1] = 0;
    conv[2] = 0;
    conv[3] = 1;
  } else if (ch == 'A') {
    conv[0] = 1;
    conv[1] = 0;
    conv[2] = 1;
    conv[3] = 0;
  } else if (ch == 'B') {
    conv[0] = 1;
    conv[1] = 0;
    conv[2] = 1;
    conv[3] = 1;
  } else if (ch == 'C') {
    conv[0] = 1;
    conv[1] = 1;
    conv[2] = 0;
    conv[3] = 0;
  } else if (ch == 'D') {
    conv[0] = 1;
    conv[1] = 1;
    conv[2] = 0;
    conv[3] = 1;
  } else if (ch == 'E') {
    conv[0] = 1;
    conv[1] = 1;
    conv[2] = 1;
    conv[3] = 0;
  } else if (ch == 'F') {
    conv[0] = 1;
    conv[1] = 1;
    conv[2] = 1;
    conv[3] = 1;
  }
}
bool check(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      for (int p = i; p < i + x; p++) {
        for (int q = j; q < j + x; q++) {
          if (arr[i][j] != arr[p][q]) return 0;
        }
      }
    }
  }
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    int l = n / 4;
    for (int j = 1; j <= l; j++) {
      con(s[j - 1]);
      arr[i][4 * (j - 1) + 1] = conv[0];
      arr[i][4 * (j - 1) + 2] = conv[1];
      arr[i][4 * (j - 1) + 3] = conv[2];
      arr[i][4 * (j - 1) + 4] = conv[3];
    }
  }
  int l = 1, h = n;
  vector<int> v;
  for (int i = n; i >= 1; i--) {
    if (n % i == 0 && check(i)) {
      cout << i << endl;
      break;
    }
  }
}
