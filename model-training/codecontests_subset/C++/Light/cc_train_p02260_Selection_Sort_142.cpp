#include<iostream>
#include<algorithm>
using namespace std;
int main(){
    int i,j,A[100],N,minJ,cnt=0;
    cin >> N;
    for(i=0;i<N;i++) cin >> A[i];
    for(i=0;i<N;i++){
        minJ=i;
        for(j=i+1;j<N;j++){
            if(A[j]<A[minJ]) minJ=j;
        }
        swap(A[i],A[minJ]);
        if(minJ!=i) cnt++;
    }
    for(i=0;i<N;i++) cout << (i!=0?" ":"") << A[i];
    cout << endl << cnt << endl;
}
