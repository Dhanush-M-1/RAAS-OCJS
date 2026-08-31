#include <iostream>
#include <string>
using namespace std;

int w[42]; // 1-origin
int n;
static const int secToNum[6] = {0, 5, 7, 5, 7, 7};

bool solve(int x) {
  int sum;
  for (int sec = 1; sec <= 5; sec++) {
    sum = 0;
    while (sum < secToNum[sec]) {
      sum += w[x];
      x++;
    }
    if (sum > secToNum[sec]) {
      return false;
    }
  }
  return true;
}

int main() {
  while (1) {
    cin >> n;
    if (n == 0) {
      break;
    }

    string s;
    for (int i = 1; i <= n; i++) {
      cin >> s;
      w[i] = s.size();
    }

    for (int i = 1; i <= n; i++) {
      if (solve(i)) {
        cout << i << endl;
        break;
      }
    }
  }

  return 0;
}