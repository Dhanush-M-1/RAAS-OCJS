#include <bits/stdc++.h>
using namespace std;
const double pi = 3.141592653589;
const long long int zero = 0;
long long int mod = 1000000007;
const long long int inf = 1e9;
const long long int inff = 1000000000000000000;
char digits[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
char al[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
               'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
char capital[26] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                    'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    long long int n, d;
    cin >> n >> d;
    long long int arr[n];
    for (int i = 0; i < n; i += 1) {
      cin >> arr[i];
    }
    long long int ma[n];
    ma[n - 1] = d;
    for (int i = n - 2; i >= 0; i -= 1) {
      ma[i] = ma[i + 1] - arr[i + 1];
      ma[i] = min(ma[i], d);
    }
    long long int sum = 0, ans = 0;
    for (int i = 0; i < n; i += 1) {
      if (arr[i] == 0) {
        if (sum < 0) {
          ans++;
          sum = ma[i];
          if (sum < 0) {
            sum = 0;
          }
          if (sum > ma[i]) {
            cout << "-1\n";
            return 0;
          }
        }
      } else {
        sum += arr[i];
        if (sum > ma[i]) {
          cout << "-1\n";
          return 0;
        }
      }
    }
    cout << ans;
  }
}
