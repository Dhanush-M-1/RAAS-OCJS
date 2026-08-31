#include<iostream>
using namespace std;

void selectionSort(int a[],int n){
    int min,c=0;
    for(int i=0;i<n;i++){
        min=i;
        for(int j=i;j<n;j++){
            if(a[min]>a[j]) min=j;
        }
        swap(a[i],a[min]);
        if(i!=min) c++;
    }
    for(int i=0;i<n;i++) cout<<a[i]<<((i==n-1)?'\n':' ');
    cout<<c<<endl;
}
 
int main(){
    int n,a[100];
    cin>>n;
    for(int i=0;i<n;i++) cin>>a[i];
    selectionSort(a, n);
}
