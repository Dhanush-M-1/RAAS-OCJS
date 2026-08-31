#include <bits/stdc++.h>
using namespace std;
int n, cur, s, pos, neg;
char ch, p;
queue<int> positive, negative;
vector<char> sign;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> ch;
  p = ch;
  while (1) {
    if (p == '=') {
      cin >> n;
      break;
    } else {
      cin >> ch;
      if (p == '+') {
        pos++;
        sign.push_back('+');
      } else if (p == '-') {
        neg++;
        sign.push_back('-');
      }
      p = ch;
    }
  }
  int left = (n + neg);
  pos++;
  for (int i = 0; i < pos; i++) {
    positive.push(max(1, min(n, left - (pos - i) + 1)));
    cur += max(1, min(n, left - (pos - i) + 1));
    left = (n + neg) - cur;
  }
  left = cur - n;
  for (int i = 0; i < neg; i++) {
    negative.push(max(1, min(n, left - (neg - i) + 1)));
    cur -= max(1, min(n, left - (neg - i) + 1));
    left = cur - n;
  }
  if (cur != n) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  cout << positive.front();
  positive.pop();
  for (int i = 0; i < sign.size(); i++) {
    cout << " " << sign[i] << " ";
    if (sign[i] == '+') {
      cout << positive.front();
      positive.pop();
    } else {
      cout << negative.front();
      negative.pop();
    }
  }
  cout << " = " << n << '\n';
  return 0;
}
