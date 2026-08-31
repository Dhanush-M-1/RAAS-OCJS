#include <iostream>
#include <algorithm>
#include <utility>

using namespace std;

int bubbleSort(int A[], int N) {
    int c = 0;
    bool flag = true;
    for (int i = 0; flag; i++) {
        flag = false;
        for (int j = 1; j < N-i; j++) {
            if (A[j] < A[j-1]) {
                swap(A[j], A[j-1]);
                flag = true;
                c++;
            }
        }
    }
    return c;
}

int main()
{
    int A[101];
    int N;

    while (cin >> N) {

        if (N == 0)
            break;

        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }

        cout << bubbleSort(A, N) << endl;
    }

    return 0;
}