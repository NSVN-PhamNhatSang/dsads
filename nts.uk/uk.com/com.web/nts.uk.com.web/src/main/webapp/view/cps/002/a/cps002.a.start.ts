module cps002.a {
    import setShared = nts.uk.ui.windows.setShared;

    let __viewContext: any = window['__viewContext'] || {};
    __viewContext.ready(() => {
        __viewContext.transferred.ifPresent((data: any) => {
            setShared("CPS002A_PARAMS", data);
        });

        __viewContext['viewModel'] = new vm.ViewModel();

        __viewContext.bind(__viewContext['viewModel']);

    });
}