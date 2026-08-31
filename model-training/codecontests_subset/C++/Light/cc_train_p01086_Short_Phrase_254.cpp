#include <iostream>
#include <vector>
#include <string>
using namespace std;

const int tanka[] = {5, 7, 5, 7, 7};

int main() {
    int n;
    while(cin >> n, n) {
        vector<int> len(n);
        for (int i = 0; i < n; i++) {
            string s; cin >> s;
            len[i] = s.size();
        }

        for (int i = 0; i < n; i++) {
            int idx = i;
            bool flag = true;
            for (int j = 0; flag && j < 5; j++) {
                int x = 0;
                while(idx < n && x < tanka[j]) {
                    x += len[idx];
                    idx++;
                }
                if (x != tanka[j]) flag = false;
            }
            if (flag) {
                cout << i + 1<< endl;
                break;
            }
        }
    }
}

