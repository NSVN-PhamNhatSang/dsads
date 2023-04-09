module cps001.d.service {
    import ajax = nts.uk.request.ajax;
    import format = nts.uk.text.format;
    let parentPath = "basic/organization/empfilemanagement/";
    let paths: any = {
        getAvaOrMap: 'find/getAvaOrMap/{0}/{1}',
        insertAva: "command/insertAvaOrMap",
        updateAva: "command/updateAvaOrMap",
        removeAva: "command/removeAvaOrMap",
        checkEmpFileMnExist: "find/checkEmpFileMnExist/{0}/{1}",
        permision: 'ctx/pereg/functions/auth/find-all'
        
    };

    export function getFullAvatar(sid) {
        return ajax(format(parentPath + paths.getAvaOrMap, sid, 3));
    }

    export function checkEmpFileMnExist(sid) {
        return ajax(format(parentPath + paths.checkEmpFileMnExist, sid, 0));
    }

    export function insertAvaOrMap(command) {
        return ajax(parentPath + paths.insertAva, command);
    }
    export function updateAvaOrMap(command) {
        return ajax(parentPath + paths.updateAva, command);
    }
    export function removeAvaOrMap(command) {
        return ajax(parentPath + paths.removeAva, command);
    }

    export function getCurrentEmpPermision() {
        return ajax(paths.permision);
    }
}