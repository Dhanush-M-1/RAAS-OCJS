#include <bits/stdc++.h>
using namespace std;
struct Node {
  long long val;
  Node *next;
};
Node *Root = NULL;
void _addNodeEnd(long long n) {
  if (Root == NULL) {
    Root = new Node();
    Root->next = NULL;
    Root->val = n;
  } else {
    Node *curNode = Root;
    while (curNode != NULL) curNode = curNode->next;
    Node *newNode = new Node();
    newNode->next = NULL;
    newNode->val = n;
    curNode->next = newNode;
  }
}
struct Point {
  long long x;
  long long y;
};
bool _Asc_compare(Point lhs, Point rhs) { return lhs.x < rhs.x; }
bool _Desc_compare(Point lhs, Point rhs) { return lhs.x > rhs.x; }
long long _unique(long long x, long long y) { return (x + (y * 100000)); }
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
long long a, b, c, d, e, f, g, h;
long long pls = 1, mns;
string st;
char ch, dh;
char arr[1000];
int main() {
  while (true) {
    cin >> dh >> ch;
    if (ch == '=') break;
    if (ch == '+')
      pls++;
    else if (ch == '-')
      mns++;
    arr[b++] = ch;
  }
  cin >> a;
  if (pls - a * mns > a || a * pls - mns < a) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  long long s = 0;
  for (long long i = 0; i < b; i++) {
    long long sign = 1;
    if (i > 0 && arr[i - 1] == '-') sign = -1;
    if (sign == 1) pls--;
    if (sign == -1) mns--;
    for (long long j = 1; j < a + 1; j++) {
      if (s + j * sign + pls - a * mns <= a &&
          s + j * sign + a * pls - mns >= a) {
        cout << j << " " << arr[i] << " ";
        s += j * sign;
        break;
      }
    }
  }
  cout << abs(a - s) << " = " << a << endl;
}
