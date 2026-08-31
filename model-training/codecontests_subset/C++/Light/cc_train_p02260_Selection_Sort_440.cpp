#include<iostream>
using namespace std;
int main(){
    int N;
    cin>>N;
    int A[N],i,j,minj,c=0,k;
    for(i=0;i<N;i++) cin>>A[i];
    for(i=0;i<N;i++){
        minj=i;
        for(j=i;j<N;j++){
            if(A[j]<A[minj]) minj=j;
        }
        k=A[i];
        A[i]=A[minj];
        A[minj]=k;
        if(minj!=i) c++;
    }
    for(i=0;i<N;i++){
        cout<<A[i];
        if(i!=N-1) cout<<" ";
    }
    cout<<endl<<c<<endl;
}
