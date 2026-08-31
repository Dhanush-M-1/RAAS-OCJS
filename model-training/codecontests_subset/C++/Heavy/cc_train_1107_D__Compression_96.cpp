#include <bits/stdc++.h>
using namespace std;
string f(char x) {
  if (x == '0') return "0000";
  if (x == '1') return "0001";
  if (x == '2') return "0010";
  if (x == '3') return "0011";
  if (x == '4') return "0100";
  if (x == '5') return "0101";
  if (x == '6') return "0110";
  if (x == '7') return "0111";
  if (x == '8') return "1000";
  if (x == '9') return "1001";
  if (x == 'A') return "1010";
  if (x == 'B') return "1011";
  if (x == 'C') return "1100";
  if (x == 'D') return "1101";
  if (x == 'E') return "1110";
  if (x == 'F') return "1111";
}
int main() {
  int n;
  scanf("%d", &n);
  char s[5005];
  bool allZeros = true, allOnes = true;
  vector<string> inp(5205, "");
  for (int i = 0; i < n; ++i) {
    scanf("%s", s);
    int len = strlen(s);
    for (int j = 0; j < len; ++j) {
      inp[i] += f(s[j]);
      if (s[j] == '0')
        allOnes = false;
      else if (s[j] == 'F')
        allZeros = false;
      else {
        allZeros = false;
        allOnes = false;
      }
    }
  }
  if (allZeros || allOnes) {
    cout << n << endl;
    return 0;
  }
  vector<int> div;
  for (int i = 1; i <= sqrt(n) + 1; ++i) {
    if (n % i == 0) {
      if (i == (n / i))
        div.push_back(i);
      else {
        div.push_back(i);
        div.push_back(n / i);
      }
    }
  }
  sort(div.begin(), div.end());
  int ans = 1;
  for (int i = 1; i < div.size(); i++) {
    bool success = true;
    for (int j = 0; j < n / div[i]; j++) {
      for (int k = 0; k < n / div[i]; k++) {
        allZeros = true, allOnes = true;
        for (int l = 0; l < div[i]; l++) {
          for (int m = 0; m < div[i]; m++) {
            if (inp[j * div[i] + l][k * div[i] + m] == '0')
              allOnes = false;
            else if (inp[j * div[i] + l][k * div[i] + m] == '1')
              allZeros = false;
          }
        }
        if (allOnes || allZeros)
          ;
        else {
          success = false;
          break;
        }
      }
    }
    if (success) ans = max(ans, div[i]);
  }
  cout << ans << endl;
  return 0;
}
