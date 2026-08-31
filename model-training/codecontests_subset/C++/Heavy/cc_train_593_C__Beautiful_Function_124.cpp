#include <bits/stdc++.h>
using namespace std;
int N, x, y, r, dx, dy, A, B;
string G("0"), T("0"), E("");
int main(void) {
  cin >> N;
  for (int i(0); i < N; ++i)
    cin >> x >> y >> r, x -= x & 1, y -= y & 1,
        dx = x - A, dy = y - B, A += dx, B += dy,
        G += (dx < 0 ? "-" : "+") + E + "(" + to_string(abs(dx / 2)) +
             "*((abs((t-" + to_string(i) + "))-abs((t-" + to_string(i + 1) +
             ")))+1))",
        T += (dy < 0 ? "-" : "+") + E + "(" + to_string(abs(dy / 2)) +
             "*((abs((t-" + to_string(i) + "))-abs((t-" + to_string(i + 1) +
             ")))+1))",
        G = "(" + G + ")", T = "(" + T + ")";
  cout << G << endl << T << endl;
  return 0;
}
