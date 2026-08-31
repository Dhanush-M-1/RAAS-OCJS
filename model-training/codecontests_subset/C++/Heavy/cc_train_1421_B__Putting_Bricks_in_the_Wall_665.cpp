#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int dim;
    cin >> dim;
    vector<vector<int> > vec;
    vector<int> load;
    string a;
    for (int i = 0; i < dim; i++) {
      cin >> a;
      for (int j = 0; j < dim; j++) {
        load.push_back(a[j] - 48);
      }
      vec.push_back(load);
      load.clear();
    }
    if (vec[0][1] == vec[1][0]) {
      if ((vec[dim - 1][dim - 2] == vec[dim - 2][dim - 1]) &&
          (vec[0][1] == vec[dim - 1][dim - 2])) {
        cout << "2\n";
        cout << "1"
             << " "
             << "2\n";
        cout << "2"
             << " "
             << "1\n";
      } else if (vec[0][1] == vec[dim - 1][dim - 2]) {
        cout << "1" << endl;
        cout << dim << " " << dim - 1 << endl;
      } else if (vec[0][1] == vec[dim - 2][dim - 1]) {
        cout << "1" << endl;
        cout << dim - 1 << " " << dim << endl;
      } else {
        cout << "0" << endl;
      }
    } else {
      if ((vec[dim - 1][dim - 2] == vec[dim - 2][dim - 1]) &&
          (vec[0][1] == vec[dim - 1][dim - 2])) {
        cout << "1" << endl;
        cout << "1"
             << " "
             << "2" << endl;
      } else if ((vec[dim - 1][dim - 2] == vec[dim - 2][dim - 1]) &&
                 (vec[1][0] == vec[dim - 1][dim - 2])) {
        cout << "1" << endl;
        cout << "2"
             << " "
             << "1" << endl;
      } else {
        if (vec[1][0] == vec[dim - 1][dim - 2]) {
          cout << "2" << endl;
          cout << "2"
               << " "
               << "1" << endl;
          cout << dim - 1 << " " << dim << endl;
        } else if (vec[1][0] == vec[dim - 2][dim - 1]) {
          cout << "2" << endl;
          cout << "1"
               << " "
               << "2" << endl;
          cout << dim - 1 << " " << dim << endl;
        }
      }
    }
    vec.clear();
  }
  return 0;
}
