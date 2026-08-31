#include <bits/stdc++.h>
using namespace std;
mt19937 rng32(chrono::steady_clock::now().time_since_epoch().count());
const long long inf9 = 1e9, inf18 = 1e18, inf6 = 1e6, inf14 = 1e14;
const long long mod7 = inf9 + 7, mod9 = inf9 + 9;
const long long maxn = 62;
int a = 0, b = 0;
int cnt = 0;
bool help = false;
void equal(int x) {
  help = true;
  if (x < 0) return;
  assert(cnt <= 61);
  for (int i = x; i >= 0; i--) {
    int x = a + (1 << i);
    int y = b;
    int res;
    cout << "? " << x << " " << y << endl;
    cout.flush();
    cin >> res;
    cnt++;
    if (res == -1) {
      a += (1 << i);
      b += (1 << i);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int res = 1, great = 0;
  cout << "? 0 0" << endl;
  cout.flush();
  cin >> res;
  cnt++;
  if (res == 0) equal(29);
  if (res == -1) great = 1;
  if (res != 0) {
    for (int i = 29; i >= 0; i--) {
      assert(help == false);
      assert(cnt <= 60);
      int x = 1 << i;
      int y = 0, res1, res2;
      x += a;
      y += b;
      cout << "? " << x << " " << y << endl;
      cout.flush();
      cin >> res2;
      cnt++;
      x = a;
      y = (1 << i) + b;
      cout << "? " << x << " " << y << endl;
      cout.flush();
      cin >> res1;
      cnt++;
      if (great == 0) {
        if (res1 == 1 && res2 == -1) {
          a += (1 << i);
          b += (1 << i);
        }
        if (res1 == 0 && res2 == 0) {
          a += (1 << i);
          equal(i - 1);
          break;
        }
        if (res1 == 1 && res1 == res2) {
          a += (1 << i);
          great = 0;
        }
        if (res1 == -1 && res1 == res2) {
          a += (1 << i);
          great = 1;
        }
      } else {
        if (res1 == 1 && res2 == -1) {
          a += (1 << i);
          b += (1 << i);
        }
        if (res1 == 0 && res2 == 0) {
          b += (1 << i);
          equal(i - 1);
          break;
        }
        if (res1 == 1 && res1 == res2) {
          b += (1 << i);
          great = 0;
        }
        if (res1 == -1 && res1 == res2) {
          b += (1 << i);
          great = 1;
        }
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  cout.flush();
  return 0;
}
