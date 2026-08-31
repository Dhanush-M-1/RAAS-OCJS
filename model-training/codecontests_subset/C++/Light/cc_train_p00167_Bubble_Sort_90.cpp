#include <cstdio>
#include <cstdio>
#include <algorithm>
using namespace std;
int arr[101];

int main() {
    int sw, N;
    for (; ;) {
        scanf("%d", &N);
        if (N == 0) break;
        for (int i = 0; i < N; i++) scanf("%d", &arr[i]);
        bool flag = true; sw = 0;
        for (int i = 0; flag; i++) {
            flag = false;
            for (int j = N-1; j >= i+1; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr[j], arr[j-1]);
                    sw++;
                    flag = true;
                }
            }
        }
        std::printf("%d\n", sw);
    }
    return 0;
}
