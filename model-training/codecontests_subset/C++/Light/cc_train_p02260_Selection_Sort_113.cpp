#include <iostream>
using namespace std;

int main(){
    int n;
    cin >> n;

    int a[n];
    for(int i=0;i<n;i++) cin >> a[i];

    int count=0;
    for(int i=0;i<n-1;i++){
        int minj = i;
        for(int j=i;j<n;j++) if(a[j] < a[minj]) minj = j;
        int tmp = a[i];
        a[i] = a[minj];
        a[minj] = tmp;
        if(i != minj) count++;
    }
    for(int i=0;i<n-1;i++) cout << a[i] << " ";
    cout << a[n-1] << endl;
    cout << count << endl;
}