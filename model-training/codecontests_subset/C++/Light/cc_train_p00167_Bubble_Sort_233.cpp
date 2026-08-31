#include <iostream>
#include <algorithm>

using namespace std;

#define MAX_N 101

int a[MAX_N];

int main() {
    int n;
    while (cin >> n) {
        if (n == 0) break;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a[j], a[j+1]);
                    count++;
                }
            }
        }
        cout << count << endl;
    }
    return 0;
}