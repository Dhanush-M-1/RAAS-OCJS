#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:256000000")
using namespace std;
const int INF = 1000 * 1000 * 1000 + 21;
const long long int LLINF = (1ll << 60) + 5;
const int MOD = 1000 * 1000 * 1000 + 7;
int n;
string gg;
string arr[228];
int main() {
  cin >> gg;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
    if (arr[i] == gg) return 0 * printf("YES\n");
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if ((arr[i] + arr[j]).find(gg) != string::npos)
        return 0 * printf("YES\n");
    }
  }
  printf("NO\n");
  return 0;
}
