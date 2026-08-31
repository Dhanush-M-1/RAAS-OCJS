#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, a, b, c, count;
  cin >> t;
  while (t--) {
    count = 0;
    cin >> a >> b >> c;
    if (b == 0) {
      cout << 0 << "\n";
      continue;
    }
    if (a == 0) {
      if (b >= (c / 2) && c > 0) {
        count += ((c / 2) + (2 * (c / 2)));
        c = c - (2 * (c / 2));
      } else if (c > 0) {
        count += (3 * b);
        c = c - (2 * b);
      }
      cout << count << "\n";
      continue;
    }
    if (c == 0) {
      if (a >= (b / 2) && b > 0) {
        count += ((b / 2) + (2 * (b / 2)));
        b = b - (2 * (b / 2));
      } else if (b > 0) {
        count += (3 * a);
        b = b - (2 * a);
      }
      cout << count << "\n";
      continue;
    }
    long long aa = a, bb = b, cc = c;
    if (a >= (b / 2)) {
      count += ((b / 2) + (2 * (b / 2)));
      b = b - (2 * (b / 2));
    } else {
      count += (3 * a);
      b = b - (2 * a);
    }
    if (b >= (c / 2) && c > 0) {
      count += ((c / 2) + (2 * (c / 2)));
      c = c - (2 * (c / 2));
    } else {
      if (c > 0) {
        count += (3 * b);
        c = c - (2 * b);
      }
    }
    long long count1 = count;
    count = 0;
    if (bb >= (cc / 2)) {
      count += ((cc / 2) + (2 * (cc / 2)));
      bb = bb - (cc / 2);
    } else {
      count += (3 * bb);
      bb = bb - (cc / 2);
    }
    if (aa >= (bb / 2) && bb > 0) {
      count += ((bb / 2) + (2 * (bb / 2)));
      bb = bb - (2 * (bb / 2));
    } else {
      if (bb > 0) {
        count += (3 * aa);
        bb = bb - (2 * aa);
      }
    }
    long long count2 = count;
    cout << max(count1, count2) << "\n";
  }
  return 0;
}
