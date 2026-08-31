#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("unroll-loops")
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  long long ans = 0;
  int i, j, cnta = 0, cntb = 0, time = 0;
  vector<int> veca, vecb, vec;
  for (i = 0; i < n; i++) {
    int t1, a1, b1;
    cin >> t1 >> a1 >> b1;
    cnta += a1;
    cntb += b1;
    time += t1;
    if (a1 == 1 && b1 == 0) {
      veca.push_back(t1);
    } else if (a1 == 0 && b1 == 1) {
      vecb.push_back(t1);
    } else if (a1 == 1 && b1 == 1) {
      vec.push_back(t1);
    }
  }
  if (cnta < k || cntb < k) {
    cout << -1 << "\n";
  } else {
    sort(veca.begin(), veca.end());
    sort(vecb.begin(), vecb.end());
    sort(vec.begin(), vec.end());
    if (veca.size() == 0 && vecb.size() == 0) {
      for (i = 0; i < vec.size(); i++) {
        ans += vec[i];
        if ((i + 1) == k) {
          break;
        }
      }
    } else if (vec.size() == 0) {
      i = 0;
      j = 0;
      for (i = 0; i < veca.size(); i++) {
        ans += veca[i];
        if ((i + 1) == k) {
          break;
        }
      }
      for (i = 0; i < vecb.size(); i++) {
        ans += vecb[i];
        if (i + 1 == k) {
          break;
        }
      }
    } else if (veca.size() == 0 || vecb.size() == 0) {
      for (i = 0; i < vec.size(); i++) {
        ans += vec[i];
        if ((i + 1) == k) {
          break;
        }
      }
    } else {
      i = 0;
      j = 0;
      int r = 0, flag = 0;
      while (i < veca.size() || j < vecb.size() || r < vec.size()) {
        if (i < veca.size() && j < vecb.size() && r < vec.size()) {
          if ((veca[i] + vecb[j]) < vec[r]) {
            ans += (veca[i] + vecb[j]);
            i++;
            j++;
            k--;
            if (k == 0) {
              flag = 1;
              break;
            }
          } else {
            ans += (vec[r]);
            r++;
            k--;
            if (k == 0) {
              flag = 1;
              break;
            }
          }
        } else if (i >= veca.size() || j >= vecb.size()) {
          ans += vec[r];
          r++;
          k--;
          if (k == 0) {
            flag = 1;
            break;
          }
        } else if (r >= vec.size()) {
          ans += (veca[i] + vecb[j]);
          k--;
          i++;
          j++;
          if (k == 0) {
            flag = 1;
            break;
          }
        }
        if (flag) {
          break;
        }
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
