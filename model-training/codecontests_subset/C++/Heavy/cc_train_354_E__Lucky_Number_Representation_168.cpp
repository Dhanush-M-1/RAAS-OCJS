#include <bits/stdc++.h>
using namespace std;
string second;
int dp[20][12];
long long lucky[] = {0, 4, 7};
string s1, s2, s3, s4, s5, s6;
void printer(string second) {
  long long ans = 0;
  for (int i = second.size() - 1; i >= 0; i--) {
    ans = ans * 10LL + (second[i] - '0');
  }
  cout << ans << " ";
}
bool done;
int ways(int n, int rem) {
  if (done) {
    return 1;
  }
  if (n == second.size() && rem == 0) {
    printer(s1), printer(s2);
    printer(s3), printer(s4);
    printer(s5), printer(s6);
    done = true;
    return 1;
  }
  if (n == second.size()) {
    return 0;
  }
  if (dp[n][rem] != -1) {
    return dp[n][rem];
  }
  int ans = 0;
  for (int a = 0; a < 3; a++) {
    for (int b = 0; b < 3; b++) {
      for (int c = 0; c < 3; c++) {
        for (int d = 0; d < 3; d++) {
          for (int e = 0; e < 3; e++) {
            for (int first = 0; first < 3; first++) {
              int x = rem + lucky[a] + lucky[b] + lucky[c] + lucky[d] +
                      lucky[e] + lucky[first];
              if ((x % 10) == (second[n] - '0') && !done) {
                string alt1 = s1, alt2 = s2, alt3 = s3, alt4 = s4, alt5 = s5,
                       alt6 = s6;
                s1 += lucky[a] + '0';
                s2 += lucky[b] + '0';
                s3 += lucky[c] + '0';
                s4 += lucky[d] + '0';
                s5 += lucky[e] + '0';
                s6 += lucky[first] + '0';
                ans += ways(n + 1, x / 10);
                s1 = alt1;
                s2 = alt2;
                s3 = alt3;
                s4 = alt4;
                s5 = alt5;
                s6 = alt6;
              }
            }
          }
        }
      }
    }
  }
  return dp[n][rem] = ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> second;
    reverse(second.begin(), second.end());
    memset(dp, -1, sizeof dp);
    done = false;
    ways(0, 0);
    if (!done) {
      cout << "-1";
    }
    cout << "\n";
  }
  return 0;
}
