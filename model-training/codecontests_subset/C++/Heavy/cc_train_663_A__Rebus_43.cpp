#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int ans;
  int plus = 1, minus = 0;
  vector<char> signs;
  vector<int> plusNumbers, minusNumbers;
  while (cin >> s) {
    if (s == "=") break;
    if (s == "+")
      plus++;
    else if (s == "-")
      minus++;
    else
      continue;
    signs.push_back(s[0]);
  }
  cin >> ans;
  int n = ans;
  int maxAns = plus * n - minus;
  int minAns = plus - n * minus;
  if (ans <= maxAns && minAns <= ans) {
    puts("Possible");
    int inc = ans - minAns;
    for (int i = 0; i < plus; i++) plusNumbers.push_back(1);
    for (int i = 0; i < minus; i++) minusNumbers.push_back(n);
    for (int i = 0; i < plus; i++) {
      int canInc = n - 1;
      if (canInc >= inc) {
        plusNumbers[i] += inc;
        cout << plusNumbers[0] << " ";
        int plusIdx = 1;
        int minusIdx = 0;
        for (int j = 0; j < signs.size(); j++) {
          cout << signs[j] << " ";
          if (signs[j] == '+')
            cout << plusNumbers[plusIdx++] << " ";
          else
            cout << minusNumbers[minusIdx++] << " ";
        }
        cout << "= " << ans << endl;
        return 0;
      } else {
        plusNumbers[i] += canInc;
        inc -= canInc;
      }
    }
    for (int i = 0; i < minus; i++) {
      int canInc = n - 1;
      if (canInc >= inc) {
        minusNumbers[i] -= inc;
        cout << plusNumbers[0] << " ";
        int plusIdx = 1;
        int minusIdx = 0;
        for (int j = 0; j < signs.size(); j++) {
          cout << signs[j] << " ";
          if (signs[j] == '+')
            cout << plusNumbers[plusIdx++] << " ";
          else
            cout << minusNumbers[minusIdx++] << " ";
        }
        cout << "= " << ans << endl;
        return 0;
      } else {
        minusNumbers[i] -= canInc;
        inc -= canInc;
      }
    }
  } else
    puts("Impossible");
  return 0;
}
