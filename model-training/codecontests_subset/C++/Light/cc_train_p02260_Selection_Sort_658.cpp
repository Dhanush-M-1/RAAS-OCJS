#include<iostream>
#include<utility>
using namespace std;

int main(){
    int N, a[100], t=0;
    cin >> N;
    for(int i=0 ; i<N ; i++) cin >> a[i];
    for(int i=0 ; i<N ; i++){
        int minj = i;
        for(int j=i ; j<N ; j++){
            if(a[j]<a[minj]) minj=j;
        }
        swap(a[i], a[minj]);
        if(i!=minj) t++;
    }
    for(int i=0 ; i < N-1 ; i++) cout << a[i] << " ";
    cout << a[N-1] << endl;
    cout << t << endl;
    return 0;
}
