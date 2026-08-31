#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long DIS = (b * b) - (4 * a * c);
  if ((a == 0 and b == 0 and c == 0))
    cout << -1 << endl;
  else if (DIS < 0 or (a == 0 and b == 0))
    cout << 0 << endl;
  else if (a == 0)
    printf("1\n%.10lf\n", (double)-c / b);
  else {
    double x = (double)(-b + (double)sqrt(DIS)) / (2 * a);
    double y = (double)(-b - (double)sqrt(DIS)) / (2 * a);
    if (y == 0 and x == 0)
      printf("1\n%.10lf\n", 0.0);
    else {
      set<double> st;
      st.insert(x);
      st.insert(y);
      cout << st.size() << endl;
      for (set<double>::iterator it = st.begin(); it != st.end(); it++)
        printf("%.10lf\n", *it);
    }
  }
}
