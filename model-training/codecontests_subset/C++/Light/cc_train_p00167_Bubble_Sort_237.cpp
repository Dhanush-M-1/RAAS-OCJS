#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    int sort[1000000];

    while (cin >> n, n) {
        int cnt = 0;

        for (int i = 0; i < n; i++)
            cin >> sort[i];

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sort[j] > sort[j + 1]) {
                    swap(sort[j], sort[j + 1]);
                    cnt++;
                }
            }
        }
        cout << cnt << endl;
    }

    return 0;
}