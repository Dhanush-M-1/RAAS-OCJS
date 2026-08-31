#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  for (int tc = 0; tc < (t); tc += 1) {
    long long n, l, r;
    cin >> n >> l >> r;
    l--;
    bool last1 = false;
    if (r == n * (n - 1) + 1) {
      last1 = true;
      r--;
      if (r == l) {
        cout << "1\n";
        continue;
      }
    }
    long long i = 1;
    long long ptr = 0;
    while (ptr + (n - i) * 2 <= l) {
      ptr += (n - i) * 2;
      i++;
    }
    long long j = i;
    j += (l - ptr) / 2;
    if (l % 2 == 1) {
      cout << j + 1 << " ";
      j++;
      l++;
    }
    if (j != n) {
      j++;
    } else {
      i++;
      j = i + 1;
    }
    while (r > l) {
      if (r - l == 1) {
        cout << i << " ";
        break;
      }
      cout << i << " " << j << " ";
      if (j != n) {
        j++;
      } else {
        i++;
        j = i + 1;
      }
      r -= 2;
    }
    if (last1) cout << "1";
    cout << "\n";
  }
}
