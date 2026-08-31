#include <iostream>
#include <vector>
using namespace std;

int bubblesort(vector<int> a){
    int cnt = 0;
    for(int i=0; i<a.size()-1; i++){
        for(int j=a.size()-1; j>i; j--){
            if(a[j]<a[j-1]){
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
                cnt++;
            }
        }
    }

    return cnt;
}

int main(){
    int n;

    while(cin >> n, n != 0){
        vector<int> a(n);
        for(int i=0; i<n; i++){
            cin >> a[i];
        }

        int result = bubblesort(a);

        cout << result << endl;
    }
    return 0;
}