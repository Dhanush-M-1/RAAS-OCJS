#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch[2];
  queue<char> q;
  fgets(ch, 2, stdin);
  long int n = 0;
  int plus = 1;
  int minus = 0;
  while (ch[0]) {
    if (ch[0] == '+') {
      q.push(ch[0]);
      plus++;
    } else if (ch[0] == '-') {
      q.push(ch[0]);
      minus++;
    } else if (ch[0] == '=') {
      cin >> n;
      break;
    }
    fgets(ch, 2, stdin);
  }
  if (plus == minus) {
    if (q.size() == 1 || n == 1) {
      cout << "Impossible\n";
      return 0;
    } else {
      cout << "Possible\n";
      cout << n;
      plus--;
      int flag = 0;
      while (q.size() != 0) {
        if (q.front() == '-') {
          cout << " - 1";
          flag = 1;
        }
        if (q.front() == '+') {
          flag = 0;
          if (plus == (minus - 1)) {
            cout << " + 2";
            plus--;
          } else {
            cout << " + 1";
            plus--;
          }
        }
        q.pop();
      }
      cout << " = " << n << "\n";
    }
  } else if (plus < minus) {
    if ((plus * n - n) < minus) {
      cout << "Impossible\n";
      return 0;
    }
    if (n == 1) {
      cout << "Impossible\n";
      return 0;
    }
    cout << "Possible\n";
    cout << n;
    plus--;
    int save = plus;
    int k = minus % save;
    int flag = 0;
    while (q.size() != 0) {
      if (q.front() == '-') {
        cout << " - 1";
        flag = 1;
      }
      if (q.front() == '+') {
        flag = 0;
        if (plus >= (save - k + 1)) {
          cout << " + " << minus / save + 1;
          plus--;
        } else {
          cout << " + " << minus / save;
          plus--;
        }
      }
      q.pop();
    }
    cout << " = " << n << "\n";
    return 0;
  } else {
    if ((plus - (minus * n)) > n) {
      cout << "Impossible\n";
      return 0;
    }
    if (plus > n) {
      cout << "Possible\n";
      int k = 0;
      cout << "1";
      k++;
      int save = minus % (plus - n);
      if ((minus / (plus - n)) != 0) {
        while (q.size() != 0) {
          if (q.front() == '-') {
            cout << " - 1";
          }
          if (q.front() == '+') {
            if (k < n) {
              cout << " + 1";
              k++;
            } else if (k < (n + save)) {
              cout << " + " << (minus / (plus - n) + 1);
              k++;
            } else
              cout << " + " << minus / (plus - n);
          }
          q.pop();
        }
        cout << " = " << n << "\n";
        return 0;
      } else {
        int i = 2;
        for (i = 2; i <= n; i++) {
          if ((i * minus) / (plus - n) != 0) break;
        }
        save = (i * minus) % (plus - n);
        while (q.size() != 0) {
          if (q.front() == '-') {
            cout << " - " << i;
          }
          if (q.front() == '+') {
            if (k < n) {
              cout << " + 1";
              k++;
            } else if (k < (n + save)) {
              cout << " + " << ((i * minus) / (plus - n) + 1);
              k++;
            } else
              cout << " + " << (i * minus) / (plus - n);
          }
          q.pop();
        }
        cout << " = " << n << "\n";
        return 0;
      }
    }
    cout << "Possible\n";
    int k = 0;
    int save = n % (plus - minus);
    cout << n / (plus - minus) + save;
    k++;
    while (q.size() != 0) {
      if (q.front() == '-') {
        cout << " - 1";
      }
      if (q.front() == '+') {
        if ((plus - k) > minus) {
          cout << " + " << n / (plus - minus);
          k++;
        } else
          cout << " + 1";
      }
      q.pop();
    }
    cout << " = " << n << "\n";
    return 0;
  }
}
